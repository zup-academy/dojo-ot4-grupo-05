package br.com.zupedu.dojo.ot4dojo.validacao;

public class ValidacaoErro {

        private String campo;
        private String mensagem;

        public ValidacaoErro(String campo, String mensagem) {
            this.campo = campo;
            this.mensagem = mensagem;
        }

        public String getCampo() {
            return campo;
        }

        public String getMensagem() {
            return mensagem;
        }
}
