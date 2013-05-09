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

        createResource : function(groupId, resourceObj, handler) {
            if ( handler === 'silent' ) handler = (function (result) { } );
            if ( handler === undefined ) handler = (function (result) {
                if (result.error) {
                    alert('Error, unable to retrieve resources from the server.');
                }
            } ) ;
            osapi.resources.createResource({'groupId' : groupId, 'resourceObj' : resourceObj}).execute(handler);
        },

        deleteResource : function(groupId, resourceId, handler) {
            if ( handler === 'silent' ) handler = (function (result) { } );
            if ( handler === undefined ) handler = (function (result) {
                if (result.error) {
                    alert('Error, unable to retrieve resources from the server.');
                }
            } ) ;
            osapi.resources.deleteResource({'groupId' : groupId, 'resourceId' : resourceId}).execute(handler);
        }
    };
})();