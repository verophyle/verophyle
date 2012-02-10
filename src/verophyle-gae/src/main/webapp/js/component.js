//
// component.js
//

verophyle.component.Component = function(data) {
	
};

verophyle.component.Component.prototype = Object.create(Object.prototype, {
	
	constructor: { value: verophyle.component.Component },
	
	initialize: { 
		value: function() {
			if (this.data instanceof String) {
				// leave me alone
			} else if (this.data instanceof Array) {
				
			}
		} 
	},
	
	display: {
		value: function(mode, parent) {
			
		}
	},
	
	save: {
		value: function(mode, parent, stream) {
			
		}
	},
	
});
