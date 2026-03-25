package br.unipar.frameworks.commands;

import br.unipar.framework.miniframework.CommandHandler;
import br.unipar.framework.miniframework.Request;
import br.unipar.framework.miniframework.Response;

import java.util.Random;

public class DicaCommand implements CommandHandler {

    @Override
    public Response handler(Request request) {

        String[] dicas = {
                "Sempre valide os dados!",
                "Use nomes claros para variáveis.",
                "Leia os erros com atenção!",
                "Organize seu código.",
                "Pratique todos os dias!",
                "Vai ler um livro, boiola!",
                "A chuva é molhada!",
                "Dormir faz a noite passar.",
                "Frio é melhor que calor!",
                "Beba água!",
                "Morrer não é legau..."

        };

        Random random = new Random();
        String dica = dicas[random.nextInt(dicas.length)];

        return Response.ok("Dica: " + dica);
    }
}