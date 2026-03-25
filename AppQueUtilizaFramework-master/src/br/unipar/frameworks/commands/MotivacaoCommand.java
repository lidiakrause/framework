package br.unipar.frameworks.commands;

import br.unipar.framework.miniframework.CommandHandler;
import br.unipar.framework.miniframework.Request;
import br.unipar.framework.miniframework.Response;

import java.util.Random;

public class MotivacaoCommand implements CommandHandler {

    @Override
    public Response handler(Request request) {

        String[] frases = {
                "Você consegue!",
                "Confia no seu estudo!",
                "Erros fazem parte do aprendizado.",
                "Você já chegou longe, continua!",
                "Vai dar certo, respira"
        };

        Random random = new Random();
        String frase = frases[random.nextInt(frases.length)];

        return Response.ok("Motivacao: " + frase);
    }
}