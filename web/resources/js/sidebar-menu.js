var Grafix = {
    init : function() {
        this.sideMenuBar = this.sideMenuBar||$('#dashboard_sidebar');
        this.sideMenuElement = this.sideMenuBar.get(0);
        this.sideMenuContainer = this.sideMenuContainer||$('ul.layout-menubar-container');


    },
    toggleSubmenu : function(element) {
        console.log(element);
    }
};

$(function(){
    Grafix.init();
})
