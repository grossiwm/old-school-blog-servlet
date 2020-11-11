// Wait for the DOM to be ready
$((
    ()=>{

        const cpfPattern = /^\d{11}$/;
        const emailPattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;


        function getErrosCadastro() {

            const nomeInput = $('#nome');
            const cpfInput = $('input#cpf');
            const emailInput = $('#email');
            const senhaInput = $('#senha');
            const senhaConfirmacao = $('#senha-confirmacao');

            const erros = {};

            if (!cpfPattern.test(cpfInput.val().replaceAll(/\.|-/g, ""))) {
                erros['cpf'] = 'Insira um cpf válido';
            }

            if (nomeInput.val().length < 3) {
                erros['nome'] = 'Insira um nome válido';
            }
            
            if (!emailPattern.test(emailInput.val())) {
                erros['email'] = 'Insira um email válido';
            }

            if (senhaInput.val().length < 5) {
                erros['senha'] = 'senha deve ter ao mínimo 5 caracteres';
            } 

            if (senhaInput.val() !== senhaConfirmacao.val()) {
                erros['senha-confirmacao'] = 'senha e confirmação de senha não são iguais';
            } 

            return erros;
            
        }

        function getErrosLogin() {

            const erros = {};
            const cpfInput = $('input#cpf');

            if (!cpfPattern.test(cpfInput.val().replaceAll(/\.|-/g, ""))) {
                erros['cpf'] = 'Insira um cpf válido';
            }

            return erros;
    
        }   


        $('button[type=submit]').click((evento) => {
            evento.preventDefault();

            const allInputs = $('input');

            let erros={};

            for (let i = 0; i < allInputs.length; i++) {
    
                let input = allInputs[i];

                input.classList.remove('is-valid', 'is-invalid')
            }

            $('.text-danger').empty()
  
            if ($('#login-form').length > 0) {
                erros = getErrosLogin();
            }
            if ($('#cadastro-form').length > 0) {
                erros = getErrosCadastro();
            }

            if ($.isEmptyObject(erros)) {
                 $('form').submit();
            } else {
                console.log('cheio')
                Object.entries(erros).forEach(([campo, mensagem]) => {
                    $('#' + campo).addClass('is-invalid');
                    $('#' + campo + '-help').text(mensagem);
                    console.log(erros)
                    if (campo === 'senha') {
                        $('#senha-confirmacao')[0].classList.add('is-invalid');
                    }
                });


                for (let i = 0; i < allInputs.length; i++) {

                    let input = allInputs[i];

                    if (!input.classList.contains('is-invalid') && !(input.type === 'checkbox')) {
                        input.classList.add('is-valid');
                    }
                }
            }

        })




    }
));