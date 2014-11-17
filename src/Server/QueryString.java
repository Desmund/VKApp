package Server;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Denis on 26.10.2014.
 */
public class QueryString {
    private StringBuffer query;

    public QueryString(String name,String value)throws UnsupportedEncodingException{
        add(name,value);
    }

    public QueryString(){
        query = new StringBuffer();
    }

    public synchronized QueryString add(String name,Object value)throws UnsupportedEncodingException {
        if(!query.toString().trim().equals(""))query.append("&");
        query.append(URLEncoder.encode(name,"UTF-8"));
        query.append("=");
        query.append(URLEncoder.encode(value.toString(),"UTF-8"));
        return this;
    }

    @Override
    public String toString() {
        return  query.toString();
    }
}
