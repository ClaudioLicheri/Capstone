import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";

export const forbiddenValidator = (...values: string[]): ValidatorFn => {
    return(c: AbstractControl): ValidationErrors | null => {
        for (const value  of values) {
            if ( value === c.value){
                return {
                    forbidden: true
                };
            }
        }

        return null;
    }; 
};

