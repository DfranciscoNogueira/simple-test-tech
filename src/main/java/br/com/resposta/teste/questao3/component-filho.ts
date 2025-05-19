import { Component, Input } from '@angular/core';

@Component({
  selector: 'component-filho',
  template: `<h3>Mensagem do componente pai: {{ mensagem }}</h3>`
})
export class ComponentFilho {

  // o componente pai enviando dados para um filho via @Input().
  @Input() mensagem: string = '';

}