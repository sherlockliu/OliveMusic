package cn.com.magicsoft.framework.cache.suggest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import cn.com.magicsoft.framework.cache.analysis.SegToken;
import cn.com.magicsoft.framework.cache.analysis.Segmenter;
import cn.com.magicsoft.framework.cache.analysis.Segmenter.SegMode;

@Component
public class WordAnalysis {
	//Segmenter segmenter = new Segmenter();
	
	public List<String> analysisi(String content){
//		if(StringUtils.isEmpty(content))
//			return null;
//		List<String> values = new ArrayList<String>();
//		List<SegToken> tokens = segmenter.process(content, SegMode.SEARCH);
//		for (SegToken segToken : tokens) {
//			values.add(segToken.word);
//		}
//		return values;
		return null;
	}
}
