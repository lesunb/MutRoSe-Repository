package br.unb.cic.modelling.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ManageWriter {
	// Constantes
	static final int TAMANHO_BUFFER = 4096; // 4kb

	public static PrintWriter createFile(String adf, String outputFolder) throws RuntimeException {
		try {
			PrintWriter adfFile = new PrintWriter(new BufferedWriter(new FileWriter(outputFolder + adf)));
			return adfFile;
		} catch (IOException e) {
			String msg = "Error: Can't create output model file.";
			System.out.println(msg);
			throw new RuntimeException(msg);
		}
	}

	public static void printModel(PrintWriter adf, String... modules) {
		for (String module : modules) {
			adf.println(module);
		}
		adf.close();
	}

	public static File generateFile(final String path, final String nameFile, final String message) {
		File dir = new File(path);
		dir.mkdirs();
		return ManageWriter.generateFile(dir + "/" + nameFile, message);
	}

	public static File generateFile(final String nameFile, final String message) {
		try {
			File file = new File(nameFile);
			FileWriter arq = new FileWriter(file.getAbsolutePath());
			PrintWriter writeArq = new PrintWriter(arq);
			writeArq.printf(message);
			arq.close();

			return file;
		} catch (IOException e) {
			throw new RuntimeException("Error: Can't create file.");
		}
	}

	public static void toCompact(String arqEntrada, String arqSaida) throws IOException {
		int cont;
		byte[] dados = new byte[TAMANHO_BUFFER];

		BufferedInputStream origem = null;
		FileInputStream streamDeEntrada = null;
		FileOutputStream destino = null;
		ZipOutputStream saida = null;
		ZipEntry entry = null;

		try {
			destino = new FileOutputStream(new File(arqSaida));
			saida = new ZipOutputStream(new BufferedOutputStream(destino));
			File file = new File(arqEntrada);
			streamDeEntrada = new FileInputStream(file);
			origem = new BufferedInputStream(streamDeEntrada, TAMANHO_BUFFER);
			entry = new ZipEntry(file.getName());
			saida.putNextEntry(entry);

			while ((cont = origem.read(dados, 0, TAMANHO_BUFFER)) != -1) {
				saida.write(dados, 0, cont);
			}
			origem.close();
			saida.close();
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		}
	}

	public static String readFileAsString(File file) {
		String res = null;
		String filePath = file.getAbsolutePath();
		try {
			StringBuffer fileData = new StringBuffer(1000);
			BufferedReader reader = null;

			reader = new BufferedReader(new FileReader(filePath));

			char[] buf = new char[1024];
			int numRead = 0;

			while ((numRead = reader.read(buf)) != -1) {
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
			reader.close();
			res = fileData.toString();
		} catch (IOException e) {
			String msg = "Error: file " + filePath + " not found.";
			System.out.println(msg);
			throw new RuntimeException(msg);
		}
		return res;
	}

	public static String readFileAsString(String filePath) {
		String res = null;
		try {
			StringBuffer fileData = new StringBuffer(1000);
			BufferedReader reader = null;

			reader = new BufferedReader(new FileReader(filePath));

			char[] buf = new char[1024];
			int numRead = 0;

			while ((numRead = reader.read(buf)) != -1) {
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
			reader.close();
			res = fileData.toString();
		} catch (IOException e) {
			String msg = "Error: file " + filePath + " not found.";
			System.out.println(msg);
			throw new RuntimeException(msg);
		}
		return res;
	}

	public static String readFile(String path) {
		try {
			File arq = new File(path);
			StringBuilder text = new StringBuilder();
			Scanner myReader = new Scanner(arq);

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				text.append(data);
				text.append("\n");
			}
			myReader.close();

			return text.toString();
		} catch (IOException e) {
			throw new RuntimeException("Falha ao ler arquivo.");
		}
	}

	public static String readFile(File arq) {
		try {
			StringBuilder text = new StringBuilder();
			Scanner myReader = new Scanner(arq);

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				text.append(data);
				text.append("\n");
			}
			myReader.close();

			return text.toString();
		} catch (IOException e) {
			throw new RuntimeException("Falha ao ler arquivo.");
		}
	}

	public static void createFolder(String path) throws IOException {
		if (!Files.exists(Paths.get(path))) {
			Files.createDirectory(Paths.get(path));
		}
	}

	public static void cleanFolder(String path) throws IOException {
		if (Files.exists(Paths.get(path))) {
			Files.walk(Paths.get(path), FileVisitOption.FOLLOW_LINKS).sorted(Comparator.reverseOrder())
					.map(Path::toFile).forEach(f -> {
						if (f.isFile()) {
							f.delete();
						}
					});
		}
	}
}
