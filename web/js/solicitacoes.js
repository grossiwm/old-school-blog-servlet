$(() => {
    const modal = $('.modal');

    const coisasQueFechamModal = [];

    const xButton = $('span[aria-hidden=true]');
    const recusarButton = $('#recusa-button');
    const aceitarButton = $('#aceita-button');

    coisasQueFechamModal.push(xButton);
    coisasQueFechamModal.push(recusarButton);


    // coisasQueFechamModal.on('click', ()=>{
    //     modal.hide();
    // })

    coisasQueFechamModal.forEach((c)=>{
        c.on('click', ()=>{
            modal.hide();
        })
    })

    $('.list-group-item a').on('click', (evento)=>{
        modal.show();
    })

    aceitarButton.on('click', () => {
        console.log('fui')
        const id = $('#selecao-id').val();
        console.log(id)
        selecionado = $('#' + id);
        console.log(selecionado)
        selecionado.remove();
    })

})