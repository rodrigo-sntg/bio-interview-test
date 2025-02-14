package com.bionexo.provider.medicinefinder.errors;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
class ApiValidationError extends ApiSubError {
   private String object;
   private String field;
   private Object rejectedValue;
   private String message;

   ApiValidationError(String object, String message) {
       this.object = object;
       this.message = message;
   }

	public ApiValidationError(String object2, String field2, Object rejectedValue2, String message2) {
		this.object = object2;
		this.message = message2;
		this.field = field2;
		this.rejectedValue = rejectedValue2;
		
	}
}