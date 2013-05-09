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
        },

        createResource : function(groupId, obj, handler) {
            if ( handler === 'silent' ) handler = (function (result) { } );
            if ( handler === undefined ) handler = (function (result) {
                if (result.error) {
                    alert('Error, unable to retrieve resources from the server.');
                }
            } ) ;
            osapi.resources.createResource({'groupId' : groupId, 'obj' : obj}).execute(handler);
        },

        deleteResource : function(groupId, obj, handler) {
            if ( handler === 'silent' ) handler = (function (result) { } );
            if ( handler === undefined ) handler = (function (result) {
                if (result.error) {
                    alert('Error, unable to retrieve resources from the server.');
                }
            } ) ;
            osapi.resources.deleteResource({'groupId' : groupId, 'obj' : obj}).execute(handler);
        }
    };
})();