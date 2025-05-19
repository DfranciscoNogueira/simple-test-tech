import { Component } from '@angular/core';

@Component({
    selector: 'component-pai',
    template: `<component-filho [mensagem]="mensagemPai"></component-filho>`
})
export class ComponentPai {
    mensagemPai = "Olá, TESTE";
}