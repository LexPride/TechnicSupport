package com.company.technicalsupport.web.screens.appeal;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.DateField;
import com.haulmont.cuba.gui.components.FileMultiUploadField;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.screen.*;
import com.company.technicalsupport.entity.Appeal;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.time.LocalDate.now;

@UiController("technicalsupport_Appeal.edit")
@UiDescriptor("appeal-edit.xml")
@EditedEntityContainer("appealDc")
@LoadDataBeforeShow
public class AppealEdit extends StandardEditor<Appeal> {

    @Inject
    protected DateField<LocalDate> dateCreateField;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        LocalDate localDate = now();
        dateCreateField.setValue(localDate);
    }

    @Inject
    protected LookupField<String> productField;

//    @Subscribe
//    public void onInit(InitEvent event) {
//        List<String> list = new ArrayList<>();
//        list.add("ДЕЛО");
//        list.add("АРХИВНОЕ ДЕЛО");
//        list.add("Ведок");
//        productField.setOptionsList(list);
//    }

    @Inject
    private FileMultiUploadField multiUploadField;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private Notifications notifications;
    @Inject
    private DataManager dataManager;

    @Subscribe
    protected void onInit(InitEvent event) {
        // Работа с выпадающим списком
        List<String> list = new ArrayList<>();
        list.add("ДЕЛО");
        list.add("АРХИВНОЕ ДЕЛО");
        list.add("Ведок");
        productField.setOptionsList(list);


        // Работа с файлами
        multiUploadField.addQueueUploadCompleteListener(queueUploadCompleteEvent -> {
           for (Map.Entry<UUID, String> entry :
           multiUploadField.getUploadsMap().entrySet()) {
               UUID fileId = entry.getKey();
               String fileName = entry.getValue();
               FileDescriptor fd = fileUploadingAPI.getFileDescriptor(fileId, fileName);
               try {
                   fileUploadingAPI.putFileIntoStorage(fileId, fd);
               } catch (FileStorageException e) {
                   throw new RuntimeException("Error saving file to FileStorage", e);
               }
               dataManager.commit(fd);
           }
           notifications.create()
                   .withCaption("Uploaded files: " + multiUploadField.getUploadsMap().values())
                   .show();
           multiUploadField.clearUploads();
        });

        multiUploadField.addFileUploadErrorListener(queueFileUploadErrorEvent -> {
            notifications.create()
                    .withCaption("File upload error")
                    .show();
        });
    }


}