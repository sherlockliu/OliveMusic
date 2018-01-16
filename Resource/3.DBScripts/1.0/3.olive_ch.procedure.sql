USE `mordor_ch`;

DELIMITER $$ 
 -- 计算相关专辑
 drop procedure if exists CalculateRelatedAlbums $$
create procedure CalculateRelatedAlbums
(

)

begin
	DECLARE l_albumID INT; 
	DECLARE done INT DEFAULT 0; 
	DECLARE cur1 CURSOR FOR SELECT AlbumID FROM mordor_album where invalid=0; 
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done=1; 
	/*删除关联表中信息*/
	delete from mordor_AlbumScore;
	/*根据评分项插入数据到关联表*/
	INSERT INTO mordor_AlbumScore(AlbumID,ScoreID,Content,Score,CreateTime)
	select album.AlbumID, score.ScoreID,album.ArtistID,score.Score,now()
		from mordor_Album as album,mordor_Score as score
		where score.ScoreType='Artist'
	union all
	select album.AlbumID, score.ScoreID,album.Name,score.Score,now()
		from mordor_Album as album,mordor_Score as score
		where score.ScoreType='AlbumName'
	union all
	select album.AlbumID, score.ScoreID,album.MusicStyle,score.Score,now()
		from mordor_Album as album,mordor_Score as score
		where score.ScoreType='Style'
	union all
	select album.AlbumID, score.ScoreID,albumTag.TagID,score.Score,now()
		from mordor_Album as album inner join mordor_AlbumTag albumTag 
		on album.AlbumID=albumTag.AlbumID,mordor_Score as score
		where score.ScoreType='Tag';

    /*删除相关专辑表中信息*/
	delete from mordor_AlbumRelated;   
	OPEN cur1; 
		album_loop: LOOP 
			FETCH cur1 INTO l_albumID; 
			IF done=1 THEN 
				LEAVE album_loop; 
			END IF;

			INSERT INTO mordor_AlbumRelated(AlbumID,RelatedAlbumID,Score,CreateTime)
			select l_albumID, b.AlbumID,sum(b.score) as score,now() 
				from mordor_AlbumScore as a, mordor_AlbumScore as b
				where a.Content=b.Content
				and a.ScoreID=b.ScoreID
				and a.AlbumID<>b.AlbumID
				and a.AlbumID=l_albumID
				group by b.AlbumID;

		END LOOP album_loop; 
	CLOSE cur1;  
     
     
end $$

DELIMITER ;