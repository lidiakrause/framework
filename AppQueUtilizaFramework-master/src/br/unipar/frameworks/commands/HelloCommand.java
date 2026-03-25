package br.unipar.frameworks.commands;

import br.unipar.framework.miniframework.CommandHandler;
import br.unipar.framework.miniframework.Request;
import br.unipar.framework.miniframework.Response;

public class HelloCommand implements CommandHandler {

    @Override
    public Response handler(Request request) {
        String nome = request.getArgs().isEmpty() ?
                "World" : request.getArgs().getFirst();

        return Response.ok("Hello " + nome + "!");
    }

}