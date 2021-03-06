package org.wikidata.query.rdf.blazegraph.vocabulary;

import java.util.LinkedList;
import java.util.List;

import org.wikidata.query.rdf.common.uri.WikibaseUris;
import org.wikidata.query.rdf.common.uri.WikibaseUris.PropertyType;

import com.bigdata.rdf.vocab.BaseVocabularyDecl;

/**
 * Vocabulary containing the URIs from
 * {@linkplain org.wikidata.query.rdf.common.uri.Ontology} that are imported
 * into Blazegraph.
 */
public class WikibaseUrisVocabularyDecl extends BaseVocabularyDecl {

    /**
     * Get the list of URIs we will import.
     * @param uris Wikibase URIs handler
     * @return
     */
    private static List<String> getUriList(WikibaseUris uris) {
        List<String> uriList = new LinkedList<String>();
        uriList.add(uris.entity());
        /*
         * Note that these next two lines are required to make
         * WikibaseInlineUriFactory work with
         * IntegerSuffixInlineUriHandler which is required so we can
         * store entities as unsigned integers.
         */
        uriList.add(uris.entity() + "P");
        uriList.add(uris.entity() + "Q");
        uriList.add(uris.statement());
        uriList.add(uris.reference());
        uriList.add(uris.value());
        for (PropertyType p: PropertyType.values()) {
            uriList.add(uris.property(p) + "P");
        }
        return uriList;
    }

    public WikibaseUrisVocabularyDecl(WikibaseUris uris) {
        super(getUriList(uris).toArray());
    }
}
