gadgets['resources'] = (function() {

    return {
        getResources : function(data, handler) {
            if ( handler === 'silent' ) handler = (function (result) { } );
            if ( handler === undefined ) handler = (function (result) {
                if (result.error) {
                    alert('Error, unable to retrieve resources from the server.');
                }
            } ) ;
            osapi.resources.getResources({'groupId' : data}).execute(handler);
        }
    };
})();