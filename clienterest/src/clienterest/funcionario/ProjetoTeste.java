package clienterest.funcionario;

import static org.junit.Assert.fail;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Calendar;

import org.junit.Test;

public class ProjetoTeste {

	@Test
	public void testSalvar() {
		try {
			String json = "{\"name\": \"projeto de pesquisa "
					+ Calendar.getInstance().getTime() + " 2\"}";

			HttpURLConnection httpURLConnection = null;

			URL url = new URL(
					"http://localhost:8080/servidorrest/projeto/salvar");
			enviarSolicitacao(json, url);

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	private void enviarSolicitacao(String json, URL url) throws IOException,
			ProtocolException {
		HttpURLConnection httpURLConnection;
		httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection
				.setRequestProperty("Content-Type", "application/json");
		httpURLConnection.setRequestProperty("Accept", "application/json");
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setDoInput(true);
		httpURLConnection.connect();

		OutputStream outputStream = httpURLConnection.getOutputStream();
		if (json != null) {
			outputStream.write(json.getBytes());
		}
		BufferedInputStream bufferedInputStream = new BufferedInputStream(
				httpURLConnection.getInputStream());
	}

	@Test
	public void testAdicionarUm() {
		try {
			URL url = new URL(
					"http://localhost:8080/servidorrest/projeto/adicionar/1/funcionario/1/");
			enviarSolicitacao(null, url);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAdicionarDois() {
		try {
			URL url = new URL(
					"http://localhost:8080/servidorrest/projeto/adicionar/1,3/funcionario/2/");
			enviarSolicitacao(null, url);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAdicionarTres() {
		try {
			URL url = new URL(
					"http://localhost:8080/servidorrest/projeto/adicionar/1,3,4/funcionario/2/");
			enviarSolicitacao(null, url);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
}
