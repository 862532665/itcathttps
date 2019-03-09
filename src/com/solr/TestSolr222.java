package com.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * @author: 11827
 * @date: 2019/1/10 09:33
 * @description:
 */
public class TestSolr222 {
    @Test
    public void save() throws Exception {
        HttpSolrServer httpSolrServer = new HttpSolrServer("http://192.168.25.141:8080/solr");

        SolrInputDocument solrInputDocument = new SolrInputDocument();
        solrInputDocument.addField("id", "ni667");
        solrInputDocument.addField("name", "ni6683");
        httpSolrServer.add(solrInputDocument);
        httpSolrServer.commit();
    }

    @Test
    public void deleteById() throws Exception {
        HttpSolrServer httpSolrServer = new HttpSolrServer("http://192.168.25.141:8080/solr");

        httpSolrServer.deleteByQuery("*:*");
        httpSolrServer.commit();
    }

    @Test
    public void search() throws Exception {
        HttpSolrServer httpSolrServer = new HttpSolrServer("http://192.168.25.141:8080/solr");
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        solrQuery.setFilterQueries("name:ni6683");
        QueryResponse queryResponse = httpSolrServer.query(solrQuery);
        SolrDocumentList results = queryResponse.getResults();
        System.out.println(results.getNumFound());
        for (SolrDocument result : results) {
            System.out.println(result.get("id"));
            System.out.println(result.get("name"));

        }

    }
}

