package net.wespot.oauth2.provider;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.amber.oauth2.client.request.OAuthClientRequest;

/**
 * ****************************************************************************
 * Copyright (C) 2013-2017 Open Universiteit Nederland
 * <p/>
 * This library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library.  If not, see <http://www.gnu.org/licenses/>.
 * <p/>
 * Contributors: Stefaan Ternier
 * ****************************************************************************
 */
public class TestContent {

    public static final String RESOURCE_SERVER_NAME = "Example OAuth Resource Server";
    public static final String ACCESS_TOKEN_VALID = "access_token_valid";
    public static final String ACCESS_TOKEN_EXPIRED = "access_token_expired";
    public static final String ACCESS_TOKEN_INSUFFICIENT = "access_token_insufficient";

    public static final String OAUTH_VERSION_1
            = "oauth_token=\"some_oauth1_token\",realm=\"Something\",oauth_signature_method=\"HMAC-SHA1\"";
    public static final String OAUTH_VERSION_2 = ACCESS_TOKEN_VALID;
    public static final String OAUTH_VERSION_2_EXPIRED = ACCESS_TOKEN_EXPIRED;
    public static final String OAUTH_VERSION_2_INSUFFICIENT = ACCESS_TOKEN_INSUFFICIENT;

    public static final String OAUTH_URL_ENCODED_VERSION_1 = OAUTH_VERSION_1;
    public static final String OAUTH_URL_ENCODED_VERSION_2 = "access_token=" + OAUTH_VERSION_2;
    public static final String OAUTH_URL_ENCODED_VERSION_2_EXPIRED = "access_token=" + OAUTH_VERSION_2_EXPIRED;
    public static final String OAUTH_URL_ENCODED_VERSION_2_INSUFFICIENT = "access_token="
            + OAUTH_VERSION_2_INSUFFICIENT;

    public static final String AUTHORIZATION_HEADER_OAUTH1 = "OAuth " + OAUTH_VERSION_1;
    public static final String AUTHORIZATION_HEADER_OAUTH2 = "Bearer " + OAUTH_VERSION_2;
    public static final String AUTHORIZATION_HEADER_OAUTH2_EXPIRED = "Bearer " + OAUTH_VERSION_2_EXPIRED;
    public static final String AUTHORIZATION_HEADER_OAUTH2_INSUFFICIENT = "Bearer "
            + OAUTH_VERSION_2_INSUFFICIENT;

    public static final String BODY_OAUTH1 = OAUTH_URL_ENCODED_VERSION_1;
    public static final String BODY_OAUTH2 = OAUTH_URL_ENCODED_VERSION_2;
    public static final String BODY_OAUTH2_EXPIRED = OAUTH_URL_ENCODED_VERSION_2_EXPIRED;
    public static final String BODY_OAUTH2_INSUFFICIENT = OAUTH_URL_ENCODED_VERSION_2_INSUFFICIENT;

    public static final String QUERY_OAUTH1 = OAUTH_URL_ENCODED_VERSION_1;
    public static final String QUERY_OAUTH2 = OAUTH_URL_ENCODED_VERSION_2;
    public static final String QUERY_OAUTH2_EXPIRED = OAUTH_URL_ENCODED_VERSION_2_EXPIRED;
    public static final String QUERY_OAUTH2_INSUFFICIENT = OAUTH_URL_ENCODED_VERSION_2_INSUFFICIENT;

    public static final String CLIENT_ID = "test_id";
    public static final String CLIENT_SECRET = "test_secret";
    public static final String USERNAME = "test_username";
    public static final String PASSWORD = "test_password";

    public static final String HEADER_WWW_AUTHENTICATE = "WWW-Authenticate";
    public static final String HEADER_AUTHORIZATION = "Authorization";

    public static final String AUTHORIZATION_CODE = "known_authz_code";


    public static final String ASSERTION = "<samlp:AuthnRequest\n"
            + "   xmlns:samlp=\"urn:oasis:names:tc:SAML:2.0:protocol\"\n"
            + "   xmlns:saml=\"urn:oasis:names:tc:SAML:2.0:assertion\"\n"
            + "   ID=\"aaf23196-1773-2113-474a-fe114412ab72\"\n"
            + "   Version=\"2.0\"\n"
            + "   IssueInstant=\"2004-12-05T09:21:59Z\"\n"
            + "   AssertionConsumerServiceIndex=\"0\"\n"
            + "   AttributeConsumingServiceIndex=\"0\">\n"
            + "   <saml:Issuer>https://sp.example.com/SAML2</saml:Issuer>\n"
            + "   <samlp:NameIDPolicy\n"
            + "     AllowCreate=\"true\"\n"
            + "     Format=\"urn:oasis:names:tc:SAML:2.0:nameid-format:transient\"/>\n"
            + " </samlp:AuthnRequest>";
    public static final String ASSERTION_TYPE = "http://xml.coverpages.org/saml.html";

    public static final String ACCESS_TOKEN_ENDPOINT = "http://localhost:9001/auth/oauth2/token";
    public static final String AUTHORIZATION_ENPOINT = "http://localhost:9001/auth/oauth2/authz";
    public static final String REDIRECT_URL = "http://localhost:9002/auth/oauth2/redirect";
    public static final String RESOURCE_SERVER = "http://localhost:9003/resource_server";
    public static final String PROTECTED_RESOURCE_HEADER = "/resource_header";
    public static final String PROTECTED_RESOURCE_BODY = "/resource_body";
    public static final String PROTECTED_RESOURCE_QUERY = "/resource_query";

    public static final String TEST_WEBAPP_PATH = "/server";

    public static HttpURLConnection doRequest(OAuthClientRequest req) throws IOException {
        URL url = new URL(req.getLocationUri());
        HttpURLConnection c = (HttpURLConnection)url.openConnection();
        c.setInstanceFollowRedirects(true);
        c.connect();
        c.getResponseCode();

        return c;
    }
}
