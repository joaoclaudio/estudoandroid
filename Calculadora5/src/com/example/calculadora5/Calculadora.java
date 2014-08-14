package com.example.calculadora5;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class Calculadora extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... params) {
		HttpClient client = new DefaultHttpClient();
		String url = "http://calculadora.fivebits.com.br/api/values?"
				+ "operadorUm=" + params[0] + "&operadorDois=" + params[1]
				+ "&operacao=" + params[2];
		try {
			HttpGet httpget = new HttpGet(url);
			httpget.setHeader("Content-Type", "text/plain; charset=utf-8");
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			return client.execute(httpget, responseHandler);
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
