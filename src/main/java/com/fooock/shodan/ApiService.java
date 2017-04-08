/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Newhouse (nhitbh at gmail dot com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.fooock.shodan;

import com.fooock.shodan.model.dns.DnsHostname;
import com.fooock.shodan.model.dns.DnsIp;
import com.fooock.shodan.model.host.FacetReport;
import com.fooock.shodan.model.host.Host;
import com.fooock.shodan.model.host.HostReport;
import com.fooock.shodan.model.protocol.Protocol;
import com.fooock.shodan.model.query.QueryReport;
import com.fooock.shodan.model.tag.TagReport;
import com.fooock.shodan.model.token.TokenReport;
import com.fooock.shodan.model.user.Account;
import com.fooock.shodan.model.user.ApiStatus;
import com.fooock.shodan.model.user.HttpHeader;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * This API provides methods to queries Shodan, look up hosts, get summary information on queries
 * and a variety of utility methods to make developing easier
 */
public interface ApiService {

    /**
     * This method returns an object containing all the protocols that can be used when launching an
     * Internet scan.
     *
     * @param apiKey account api key
     */
    @GET("shodan/protocols")
    Observable<List<Protocol>> protocols(@Query(Constants.KEY) String apiKey);

    /**
     * Look up the hostnames that have been defined for the given list of IP addresses.
     *
     * @param apiKey account api key
     * @param ips    Comma-separated list of IP addresses; example "74.125.227.230,204.79.197.200"
     */
    @GET("dns/reverse")
    Observable<List<DnsHostname>> reverseDns(@Query(Constants.KEY) String apiKey,
                                             @Query(Constants.IPS) String ips);

    /**
     * Look up the IP address for the provided list of hostnames.
     *
     * @param apiKey    account api key
     * @param hostnames Comma-separated list of hostnames; example "google.com,bing.com"
     */
    @GET("dns/resolve")
    Observable<List<DnsIp>> resolveDns(@Query(Constants.KEY) String apiKey,
                                       @Query(Constants.HOSTNAMES) String hostnames);

    /**
     * This method returns a list of port numbers that the crawlers are looking for.
     *
     * @param apiKey account api key
     */
    @GET("shodan/ports")
    Observable<List<Integer>> ports(@Query(Constants.KEY) String apiKey);

    /**
     * This method lets you determine which filters are being used by the query string and what
     * parameters were provided to the filters.
     *
     * @param apiKey account api key
     * @param query  Shodan search query. The provided string is used to search the database of banners
     *               in Shodan, with the additional option to provide filters inside the search query using a
     *               "filter:value" format.
     */
    @GET("shodan/host/search/tokens")
    Observable<TokenReport> tokens(@Query(Constants.KEY) String apiKey,
                                   @Query(Constants.QUERY) String query);

    /**
     * Use this method to obtain a list of search queries that users have saved in Shodan.
     *
     * @param apiKey account api key
     */
    @GET("shodan/query")
    Observable<QueryReport> queries(@Query(Constants.KEY) String apiKey);

    /**
     * Use this method to obtain a list of search queries that users have saved in Shodan.
     *
     * @param apiKey account api key
     * @param page   Page number to iterate over results; each page contains 10 items
     */
    @GET("shodan/query")
    Observable<QueryReport> queries(@Query(Constants.KEY) String apiKey,
                                    @Query(Constants.PAGE) int page);

    /**
     * Use this method to obtain a list of search queries that users have saved in Shodan.
     *
     * @param apiKey account api key
     * @param page   Page number to iterate over results; each page contains 10 items
     * @param sort   Sort the list based on a property. Possible values are: votes, timestamp
     */
    @GET("shodan/query")
    Observable<QueryReport> queries(@Query(Constants.KEY) String apiKey,
                                    @Query(Constants.PAGE) int page,
                                    @Query(Constants.SORT) String sort);

    /**
     * Use this method to obtain a list of search queries that users have saved in Shodan.
     *
     * @param apiKey account api key
     * @param page   Page number to iterate over results; each page contains 10 items
     * @param sort   Sort the list based on a property. Possible values are: votes, timestamp
     * @param order  Whether to sort the list in ascending or descending order. Possible values are:
     *               asc, desc
     */
    @GET("shodan/query")
    Observable<QueryReport> queries(@Query(Constants.KEY) String apiKey,
                                    @Query(Constants.PAGE) int page,
                                    @Query(Constants.SORT) String sort,
                                    @Query(Constants.ORDER) String order);

    /**
     * Use this method to queries the directory of queries that users have saved in Shodan. For
     * default this method only return the first ten queries
     *
     * @param apiKey account api key
     * @param query  What to queries for in the directory of saved queries queries.
     */
    @GET("shodan/query/search")
    Observable<QueryReport> searches(@Query(Constants.KEY) String apiKey,
                                     @Query(Constants.QUERY) String query);

    /**
     * Use this method to queries the directory of queries that users have saved in Shodan.
     *
     * @param apiKey account api key
     * @param query  What to queries for in the directory of saved queries queries.
     * @param page   Page number to iterate over results; each page contains 10 items
     */
    @GET("shodan/query/search")
    Observable<QueryReport> searches(@Query(Constants.KEY) String apiKey,
                                     @Query(Constants.QUERY) String query,
                                     @Query(Constants.PAGE) int page);

    /**
     * Use this method to obtain a list of popular tags for the saved queries in Shodan. This method
     * only return the first ten tags
     *
     * @param apiKey account api key
     */
    @GET("shodan/query/tags")
    Observable<TagReport> tags(@Query(Constants.KEY) String apiKey);

    /**
     * Use this method to obtain a list of popular tags for the saved queries in Shodan.
     *
     * @param apiKey    account api key
     * @param tagNumber The number of tags to return (default 10).
     */
    @GET("shodan/query/tags")
    Observable<TagReport> tags(@Query(Constants.KEY) String apiKey,
                               @Query(Constants.SIZE) int tagNumber);

    /**
     * Returns all services that have been found on the given host IP.
     *
     * @param ip     HostDto IP address
     * @param apiKey account api key
     */
    @GET("shodan/host/{ip}")
    Observable<Host> hostByIp(@Path(Constants.IP) String ip, @Query(Constants.KEY) String apiKey);

    /**
     * Returns all services that have been found on the given host IP with all historical data if the
     * history param is true (default is false)
     *
     * @param ip      HostDto IP address
     * @param apiKey  account api key
     * @param history True if all historical banners should be returned (default false)
     */
    @GET("shodan/host/{ip}")
    Observable<Host> hostByIp(@Path(Constants.IP) String ip,
                              @Query(Constants.KEY) String apiKey,
                              @Query(Constants.HISTORY) boolean history);

    /**
     * Returns all services that have been found on the given host IP. If the minify param is true
     * this method returns only the list of ports and the general host information, no banners. If the
     * history param is true and minify also, then the history not takes effect
     *
     * @param ip      HostDto IP address
     * @param apiKey  account api key
     * @param history True if all historical banners should be returned (default false)
     * @param minify  True to only return the list of ports and the general host information, no
     *                banners (default false)
     */
    @GET("shodan/host/{ip}")
    Observable<Host> hostByIp(@Path(Constants.IP) String ip,
                              @Query(Constants.KEY) String apiKey,
                              @Query(Constants.HISTORY) boolean history,
                              @Query(Constants.MINIFY) boolean minify);

    /**
     * This method behaves identical to "/shodan/host/search" with the only difference that this
     * method does not return any host results, it only returns the total number of results that
     * matched the query and any facet information that was requested. As a result this method does
     * not consume query credits.
     *
     * @param apiKey account api key
     * @param query  Shodan search query. The provided string is used to search the database of banners
     *               in Shodan, with the additional option to provide filters inside the search query using a
     *               "filter:value" format
     */
    @GET("shodan/host/count")
    Observable<FacetReport> hostCount(@Query(Constants.KEY) String apiKey,
                                      @Query(Constants.QUERY) String query);

    /**
     * This method behaves identical to "/shodan/host/search" with the only difference that this
     * method does not return any host results, it only returns the total number of results that
     * matched the query and any facet information that was requested. As a result this method does
     * not consume query credits.
     *
     * @param apiKey account api key
     * @param query  Shodan search query. The provided string is used to search the database of banners
     *               in Shodan, with the additional option to provide filters inside the search query using a
     *               "filter:value" format
     * @param facets A comma-separated list of properties to get summary information on. NinvasProperty
     *               names can also be in the format of "property:count", where "count" is the number of facets that
     *               will be returned for a property
     */
    @GET("shodan/host/count")
    Observable<FacetReport> hostCount(@Query(Constants.KEY) String apiKey,
                                      @Query(Constants.QUERY) String query,
                                      @Query(Constants.FACETS) String facets);

    /**
     * Search Shodan using the same query syntax as the website and use facets to get summary
     * information for different properties. This method may use API query credits depending on usage.
     * If any of the following criteria are met, your account will be deducated 1 query credit: <ul>
     * <li>The search query contains a filter.</li> <li>Accessing results past the 1st page using the
     * "page". For every 100 results past the 1st page 1 query credit is deducted.</li> </ul>
     *
     * @param apiKey account api key
     * @param query  Shodan search query. The provided string is used to search the database of banners
     *               in Shodan, with the additional option to provide filters inside the search query using a
     *               "filter:value" format.
     */
    @GET("shodan/host/search")
    Observable<HostReport> hostSearch(@Query(Constants.KEY) String apiKey,
                                      @Query(Constants.QUERY) String query);

    /**
     * Search Shodan using the same query syntax as the website and use facets to get summary
     * information for different properties. This method may use API query credits depending on usage.
     * If any of the following criteria are met, your account will be deducated 1 query credit: <ul>
     * <li>The search query contains a filter.</li> <li>Accessing results past the 1st page using the
     * "page". For every 100 results past the 1st page 1 query credit is deducted.</li> </ul>
     *
     * @param apiKey account api key
     * @param query  Shodan search query. The provided string is used to search the database of banners
     *               in Shodan, with the additional option to provide filters inside the search query using a
     *               "filter:value" format.
     * @param facets A comma-separated list of properties to get summary information on. NinvasProperty
     *               names can also be in the format of "property:count", where "count" is the number of facets that
     *               will be returned for a property
     */
    @GET("shodan/host/search")
    Observable<HostReport> hostSearch(@Query(Constants.KEY) String apiKey,
                                      @Query(Constants.QUERY) String query,
                                      @Query(Constants.FACETS) String facets);

    /**
     * Search Shodan using the same query syntax as the website and use facets to get summary
     * information for different properties. This method may use API query credits depending on usage.
     * If any of the following criteria are met, your account will be deducated 1 query credit: <ul>
     * <li>The search query contains a filter.</li> <li>Accessing results past the 1st page using the
     * "page". For every 100 results past the 1st page 1 query credit is deducted.</li> </ul>
     *
     * @param apiKey account api key
     * @param query  Shodan search query. The provided string is used to search the database of banners
     *               in Shodan, with the additional option to provide filters inside the search query using a
     *               "filter:value" format.
     * @param facets A comma-separated list of properties to get summary information on. NinvasProperty
     *               names can also be in the format of "property:count", where "count" is the number of facets that
     *               will be returned for a property
     * @param page   The page number to page through results 100 at a time (default: 1)
     */
    @GET("shodan/host/search")
    Observable<HostReport> hostSearch(@Query(Constants.KEY) String apiKey,
                                      @Query(Constants.QUERY) String query,
                                      @Query(Constants.FACETS) String facets,
                                      @Query(Constants.PAGE) int page);

    /**
     * Returns information about the Shodan account linked to the api key.
     *
     * @param apiKey account api key
     */
    @GET("account/profile")
    Observable<Account> account(@Query(Constants.KEY) String apiKey);

    /**
     * Returns information about the API plan belonging to the given API key.
     *
     * @param apiKey account api key
     */
    @GET("api-info")
    Observable<ApiStatus> info(@Query(Constants.KEY) String apiKey);

    /**
     * Get your current IP address as seen from the Internet.
     *
     * @param apiKey account api key
     */
    @GET("tools/myip")
    Observable<String> ip(@Query(Constants.KEY) String apiKey);

    /**
     * Shows the HTTP headers that your client sends when connecting to a webserver.
     *
     * @param apiKey account api key
     */
    @GET("tools/httpheaders")
    Observable<HttpHeader> httpHeaders(@Query(Constants.KEY) String apiKey);

    /**
     * Calculates a honeypot probability score ranging from 0 (not a honeypot) to 1.0 (is a honeypot).
     *
     * @param ip     HostDto IP address
     * @param apiKey account api key
     */
    @GET("labs/honeyscore/{ip}")
    Observable<Float> honeyScore(@Path(Constants.IP) String ip, @Query(Constants.KEY) String apiKey);
}
