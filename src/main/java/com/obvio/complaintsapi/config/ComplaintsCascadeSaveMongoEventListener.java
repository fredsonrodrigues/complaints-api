package com.obvio.complaintsapi.config;

import com.obvio.complaintsapi.model.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

public class ComplaintsCascadeSaveMongoEventListener extends AbstractMongoEventListener<Object> {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object source = event.getSource();
        if ((source instanceof Complaint) && (((Complaint) source).getCompany() != null)) {
            mongoOperations.save(((Complaint) source).getCompany());
        }
    }
}
