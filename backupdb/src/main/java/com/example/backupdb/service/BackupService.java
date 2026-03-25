package com.example.backupdb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BackupService {

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    private final String backupFolder = "backups/";

    @Scheduled(cron = "0 */2 * * * *")  // a cada 2 minutos
    public void gerarBackup() throws IOException, InterruptedException {

        // garante que a pasta exista
        File pasta = new File(backupFolder);
        if (!pasta.exists()) {
            pasta.mkdir();
        }

        // pega o nome do banco a partir da URL
        String dbName = dbUrl.substring(dbUrl.lastIndexOf("/") + 1);

        // cria nome com data e hora
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String fileName = backupFolder + "backup_" + timestamp + ".sql";

        // caminho do pg_dump
        String pgDumpPath = "C:\\Program Files\\PostgreSQL\\16\\bin\\pg_dump.exe";

        // comando
        ProcessBuilder pb = new ProcessBuilder(
                pgDumpPath,
                "-U", dbUser,
                "-F", "p",
                "-f", fileName,
                dbName
        );

        // adiciona senha
        pb.environment().put("PGPASSWORD", dbPassword);

        // executa
        Process process = pb.start();
        int exitCode = process.waitFor();

        if (exitCode == 0) {
            System.out.println("Backup criado com sucesso: " + fileName);
        } else {
            System.out.println("Erro ao gerar backup.");
        }
    }
}
