import { Directive, Input } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from '@angular/forms';
import { forbiddenValidator } from '../validators/string.validator';

@Directive({
  providers: [{
    multi: true,
    provide:NG_VALIDATORS,
    useExisting: ForbiddenDirective
  }],
  selector: '[appForbidden]'
})
  export class ForbiddenDirective implements Validator {

  @Input('appForbidden') public forbidden!:string[];
  
  constructor() {}

  public validate(control: AbstractControl): ValidationErrors | null {
    return forbiddenValidator(...this.forbidden)(control);
  }

}
