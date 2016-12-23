package org.xbib.elasticsearch.plugin.hyphen;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;
import org.xbib.elasticsearch.index.analysis.hyphen.HyphenAnalyzerProvider;
import org.xbib.elasticsearch.index.analysis.hyphen.HyphenTokenFilterFactory;
import org.xbib.elasticsearch.index.analysis.hyphen.HyphenTokenizerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 */
public class HyphenPlugin extends Plugin implements AnalysisPlugin {

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> extra = new LinkedHashMap<>();
        extra.put("hyphen", HyphenTokenFilterFactory::new);
        return extra;
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
        Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> extra = new LinkedHashMap<>();
        extra.put("hyphen", HyphenTokenizerFactory::new);
        return extra;
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> extra = new LinkedHashMap<>();
        extra.put("hyphen", HyphenAnalyzerProvider::new);
        return extra;
    }
}
