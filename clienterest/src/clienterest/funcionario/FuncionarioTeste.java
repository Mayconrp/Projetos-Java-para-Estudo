package clienterest.funcionario;

import static org.junit.Assert.fail;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class FuncionarioTeste {

	@Test
	public void testSalvar(){
		try {
		String json = "{name:alex, salary:5.000}";
		
		HttpURLConnection httpURLConnection = null;
		
		URL url = new URL("http://localhost:8080/servidorrest/funcionario/salvar");
		httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestProperty("Content-Type", "application/json");
		httpURLConnection.setRequestProperty("Accept", "application/json");
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setDoInput(true);
		httpURLConnection.connect();

		OutputStream outputStream = httpURLConnection.getOutputStream();
		outputStream.write(json.getBytes());
		BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());

		}catch (Exception e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	@Test
	public void testePesquisar(){
		try{

		HttpURLConnection httpURLConnection = null;
		
		URL url = new URL("http://localhost:8080/servidorrest/funcionario/listar/");
		httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestProperty("Content-Type", "application/json");
		httpURLConnection.setRequestProperty("Accept", "application/json");
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setDoOutput(true);
		httpURLConnection.connect();
		
		String retornoJson = convertInputStreamToString(httpURLConnection.getInputStream());
		
		System.out.println(retornoJson);
		
	}catch (Exception e){
		e.printStackTrace();
		fail(e.getMessage());
	}
	}
	
	
	private String convertInputStreamToString(InputStream inputStream)
			throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		while ((line = bufferedReader.readLine()) != null)
			result += line;

		inputStream.close();
		return result;

	}

}
