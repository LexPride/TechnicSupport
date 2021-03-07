package com.company.technicalsupport.web.screens.appeal;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.technicalsupport.entity.Appeal;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.entity.UserRole;
import com.haulmont.cuba.security.global.UserSession;

import java.util.List;

@UiController("technicalsupport_Appeal.browse")
@UiDescriptor("appeal-browse.xml")
@LookupComponent("appealsTable")
@LoadDataBeforeShow
public class AppealBrowse extends StandardLookup<Appeal> {

//    @Subscribe(id = "appealsDl", target = Target.DATA_LOADER)
//    public void onAppealsDlPreLoad(CollectionLoader.PreLoadEvent<Appeal> event) {
//        UserSession userSession = null;
//        User user = userSession.getCurrentOrSubstitutedUser();
//        List<UserRole> roles = user.getUserRoles();
//
//        for (int i = 0; i < roles.size(); i++) {
//            if (roles.get(i).getRoleName().equals("User"))
//            ;// Здесь должен быть запрос в БД на показ только записей текушего пользователя
//        }
//    }
}