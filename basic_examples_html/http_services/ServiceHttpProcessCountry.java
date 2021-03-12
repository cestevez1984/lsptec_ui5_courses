package com.lsptec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;



/**
 * Servlet implementation class ServiceHttpProcessCustomer
 */
@WebServlet("/ServiceHttpProcessCountry")
public class ServiceHttpProcessCountry extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceHttpProcessCountry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//response.setContentType("application/json");
		//response.setCharacterEncoding("UTF-8");
		String currency = request.getParameter("country");
		if(currency==null) {
			currency = "DO";
		}
		String urlString = "https://restcountries.eu/rest/v2/alpha/"+currency;
		System.out.println(urlString);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		final HttpGet httpget = new HttpGet(urlString);
		System.out.println("Request Type: "+httpget.getMethod());

	    try {
			CloseableHttpResponse httpResponse = httpclient.execute(httpget);
			HttpEntity ent = httpResponse.getEntity();
			System.out.println(ent.getContentType()+""+ent.getContentLength());
			BufferedReader buff = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			String line = "";
			String data = "";
			while((line = buff.readLine())!=null) {
				System.out.println(line);
				data = line;
			}
			PrintWriter out = response.getWriter();
			out.println(data);


		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		String currency = request.getParameter("country");
		if(currency==null) {
			currency = "DO";
		}

		String urlString = "https://restcountries.eu/rest/v2/alpha/"+currency;
		System.out.println(urlString);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		final HttpGet httpget = new HttpGet(urlString);
		System.out.println("Request Type: "+httpget.getMethod());

	    try {
			CloseableHttpResponse httpResponse = httpclient.execute(httpget);
			HttpEntity ent = httpResponse.getEntity();
			System.out.println(ent.getContentType()+""+ent.getContentLength());
			BufferedReader buff = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			String line = "";
			String data = "";
			while((line = buff.readLine())!=null) {
				System.out.println(line);
				data = line;
			}
			PrintWriter out = response.getWriter();
			out.println(data);


		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

}
