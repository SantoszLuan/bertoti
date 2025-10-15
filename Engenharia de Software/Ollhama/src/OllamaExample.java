import java.io.*;
import java.net.*;

public class OllamaExample {
    public static void main(String[] args) {
        try {
            // Usa 127.0.0.1 pois o log mostra que o Ollama escuta nesse IP
            URL url = new URL("http://127.0.0.1:11434/api/generate");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // JSON correto segundo a API atual
            String jsonInput = """
                {
                  "model": "codellama:7b",
                  "prompt": "Escreva uma função em Java que inverta uma string.",
                  "stream": false
                }
                """;

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInput.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int status = conn.getResponseCode();
            System.out.println("HTTP Status: " + status);

            // Lê resposta (erro ou sucesso)
            InputStream responseStream = (status >= 200 && status < 300)
                    ? conn.getInputStream()
                    : conn.getErrorStream();

            try (BufferedReader in = new BufferedReader(new InputStreamReader(responseStream, "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line.trim());
                }
                System.out.println("Resposta do Ollama:");
                System.out.println(response.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//Instalar o Ollhama e colocar: "ollama pull codellama:7b" no terminal
