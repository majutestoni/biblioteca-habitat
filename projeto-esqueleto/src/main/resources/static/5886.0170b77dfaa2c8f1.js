"use strict";(self.webpackChunkapp=self.webpackChunkapp||[]).push([[5886],{5886:(O,g,a)=>{a.r(g),a.d(g,{TurmasPageModule:()=>N});var c=a(9808),d=a(3075),i=a(9928),T=a(4466),u=a(8555),h=a(7769),m=a(4097),e=a(6435),b=a(9057),P=a(363),_=a(8194),M=a(6138),Z=a(1062);function v(t,l){1&t&&e._UZ(0,"ion-menu-button",8)}function F(t,l){if(1&t){const n=e.EpF();e.TgZ(0,"ion-button",9),e.NdJ("click",function(){return e.CHM(n),e.oxw().audit()}),e._UZ(1,"ion-icon",10),e._uU(2),e.ALo(3,"translate"),e.qZA()}if(2&t){const n=e.oxw();e.Q6J("disabled",!(null!=n.selecteds&&n.selecteds.length)||(null==n.selecteds?null:n.selecteds.length)>1),e.xp6(2),e.hij(" ",e.lcZ(3,2,"furbot.Auditoria")," ")}}function x(t,l){1&t&&(e.TgZ(0,"span"),e._uU(1),e.ALo(2,"translate"),e.qZA()),2&t&&(e.xp6(1),e.Oqu(e.lcZ(2,1,"furbot.duplicar")))}function A(t,l){if(1&t){const n=e.EpF();e.TgZ(0,"ion-button",11),e.NdJ("click",function(){return e.CHM(n),e.oxw().duplicate()}),e._UZ(1,"ion-icon",12),e.YNc(2,x,3,3,"span",13),e.qZA()}if(2&t){const n=e.oxw();e.Q6J("disabled",!(null!=n.selecteds&&n.selecteds.length)||(null==n.selecteds?null:n.selecteds.length)>1),e.xp6(2),e.Q6J("ngIf",!n.isMobile)}}function J(t,l){1&t&&(e.TgZ(0,"span"),e._uU(1),e.ALo(2,"translate"),e.qZA()),2&t&&(e.xp6(1),e.Oqu(e.lcZ(2,1,"furbot.remover")))}function C(t,l){if(1&t){const n=e.EpF();e.TgZ(0,"ion-button",14),e.NdJ("click",function(){return e.CHM(n),e.oxw().delete()}),e._UZ(1,"ion-icon",15),e.YNc(2,J,3,3,"span",13),e.qZA()}if(2&t){const n=e.oxw();e.Q6J("disabled",!(null!=n.selecteds&&n.selecteds.length)),e.xp6(2),e.Q6J("ngIf",!n.isMobile)}}const I=function(t){return{"ion-no-border":t}},Y=[{path:"",component:(()=>{class t extends h._{constructor(n,o,s,r,p,f,L){super(n,o,r,"/professor/turmas/form-turmas",s,p,f),this.alertController=n,this.router=o,this.utils=s,this.service=r,this.activatedRoute=p,this.appLoader=f,this.appStorage=L}getFixedFilter(){return`professorId IGUAL ${this.appStorage.get(m.u.KEY_STORAGE.logado).id}${this.fixedFilter?` AND ${this.fixedFilter}`:""}`}ngOnInit(){}}return t.\u0275fac=function(n){return new(n||t)(e.Y36(i.Br),e.Y36(u.F0),e.Y36(b.c),e.Y36(P.R),e.Y36(u.gz),e.Y36(_.P),e.Y36(m.u))},t.\u0275cmp=e.Xpm({type:t,selectors:[["app-turmas"]],features:[e.qOj],decls:14,vars:24,consts:[["mode","md",3,"ngClass"],["class","ml-2","slot","start",4,"ngIf"],["slot","start","mode","ios",1,"mt-3","searchbar-top",3,"ngModel","placeholder","ngModelChange","ionBlur","ionFocus"],["slot","end"],[3,"disabled","click",4,"ngIf"],["fill","clear",3,"disabled","click",4,"ngIf"],["color","danger","fill","clear",3,"disabled","click",4,"ngIf"],["actionsLabel","Selecionar",3,"service","isMobile","title","editLabel","update","subtitle","fixedFilter","add","edit","selected"],["slot","start",1,"ml-2"],[3,"disabled","click"],["name","receipt-outline",1,"mr-2"],["fill","clear",3,"disabled","click"],["name","copy-outline",1,"mr-2"],[4,"ngIf"],["color","danger","fill","clear",3,"disabled","click"],["name","trash-outline",1,"mr-2"]],template:function(n,o){1&n&&(e.TgZ(0,"ion-header",0)(1,"ion-toolbar"),e.YNc(2,v,1,0,"ion-menu-button",1),e.TgZ(3,"ion-searchbar",2),e.NdJ("ngModelChange",function(r){return o.filterStr=r})("ngModelChange",function(){return o.onGlobalFilter("nome")})("ionBlur",function(){return o.searchbarFocus(!1)})("ionFocus",function(){return o.searchbarFocus(!0)}),e.ALo(4,"translate"),e.qZA(),e.TgZ(5,"ion-buttons",3),e.YNc(6,F,4,4,"ion-button",4),e.YNc(7,A,3,2,"ion-button",5),e.YNc(8,C,3,2,"ion-button",6),e.qZA()()(),e.TgZ(9,"ion-content")(10,"app-lista-generica",7),e.NdJ("add",function(){return o.onAdd()})("edit",function(r){return o.onEdit(r)})("selected",function(r){return o.selectedProcedures(r)}),e.ALo(11,"translate"),e.ALo(12,"translate"),e.ALo(13,"translate"),e.qZA()()),2&n&&(e.Q6J("ngClass",e.VKq(22,I,o.scrollTop<10)),e.xp6(2),e.Q6J("ngIf",o.isMobile),e.xp6(1),e.Q6J("ngModel",o.filterStr)("placeholder",e.lcZ(4,14,"furbot.pesquisePorTurmas")),e.xp6(3),e.Q6J("ngIf",!o.searchFocus&&!o.isMobile),e.xp6(1),e.Q6J("ngIf",!o.searchFocus),e.xp6(1),e.Q6J("ngIf",!o.searchFocus),e.xp6(2),e.Q6J("service",o.service)("isMobile",o.isMobile)("title",e.lcZ(11,16,"furbot.gestao.de.turmas"))("editLabel",e.lcZ(12,18,"furbot.editar"))("update",o.updateTable)("subtitle",e.lcZ(13,20,"furbot.verifique.aqui.todas.as.suas.turmas"))("fixedFilter",o.getFixedFilter()))},directives:[i.Gu,c.mk,i.sr,c.O5,i.fG,i.VI,i.j9,d.JJ,d.On,i.Sm,i.YG,i.gu,i.W2,M.Q],pipes:[Z.X$],styles:[".ui-dropdown.ui-dropdown-clearable[_ngcontent-%COMP%]   .ui-dropdown-label[_ngcontent-%COMP%], .ui-dropdown[_ngcontent-%COMP%]   .ui-dropdown-label[_ngcontent-%COMP%]{text-overflow:ellipsis}"]}),t})()},{path:"form-turmas",loadChildren:()=>Promise.all([a.e(8592),a.e(6962)]).then(a.bind(a,6962)).then(t=>t.FormTurmasPageModule)},{path:":id/senha",loadChildren:()=>Promise.all([a.e(8592),a.e(9384)]).then(a.bind(a,9384)).then(t=>t.AlteraSenhaPageModule)}];let Q=(()=>{class t{}return t.\u0275fac=function(n){return new(n||t)},t.\u0275mod=e.oAB({type:t}),t.\u0275inj=e.cJS({imports:[[u.Bz.forChild(Y)],u.Bz]}),t})(),N=(()=>{class t{}return t.\u0275fac=function(n){return new(n||t)},t.\u0275mod=e.oAB({type:t}),t.\u0275inj=e.cJS({imports:[[c.ez,d.u5,i.Pc,Q,T.m]]}),t})()}}]);