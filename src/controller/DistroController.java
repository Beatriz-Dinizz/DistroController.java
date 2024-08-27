package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DistroController {

	public DistroController() {
		super();
	}
	
	private String os() {
        return System.getProperty("os.name");
    }

    public void exibeDistro() {
        String os = os();

        if (os.contains("nux")) {
            try {
                Process process = Runtime.getRuntime().exec("cat /etc/os-release");
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String linha;
                String nomeDistro = "";
                String versaoDistro = "";

                while ((linha = reader.readLine()) != null) {
                    if (linha.startsWith("NAME=")) {
                    	nomeDistro = linha.split("=")[1].replace("\"", "");
                    }
                    if (linha.startsWith("VERSION=")) {
                    	versaoDistro = linha.split("=")[1].replace("\"", "");
                    }
                }

                reader.close();
                System.out.println("Distribuição: " + nomeDistro);
                System.out.println("Versão: " + versaoDistro);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("O sistema operacional não é Linux.");
        }
    }

}
