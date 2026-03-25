package br.unipar.frameworks.commands;

import br.unipar.framework.miniframework.CommandHandler;
import br.unipar.framework.miniframework.Request;
import br.unipar.framework.miniframework.Response;

public class SomaCommand implements CommandHandler {

    @Override
    public Response handler(Request request) {
        if(request.getArgs().size() < 2 ||
            request.getArgs().size() >= 3) {
            return Response.badRequest("Uso: soma <num1> <num2>");
        }

        try {
            double num1 = Double.parseDouble(request.getArgs().get(0));
            double num2 = Double.parseDouble(request.getArgs().get(1));
            return Response.ok("Resultado: " + (num1 + num2));
        } catch (NumberFormatException e) {
            return Response.badRequest("Os argumentos devem ser números.");
        }
    }

}
