package br.com.zupedu.dojo.ot4dojo.validacao;

import java.util.List;

public class CorpoDeErro {


    private List<Object> erros;

    public CorpoDeErro(List<Object> erros) {
        this.erros = erros;
    }

    public List<Object> getErros() {
        return erros;
    }

    static class Object {

        private String code;
        private String mensagem;

        public Object(String campo, String mensagem) {
            this.code = campo;
            this.mensagem = mensagem;
        }

        public String getCode() {
            return code;
        }

        public String getMensagem() {
            return mensagem;
        }
    }
}
