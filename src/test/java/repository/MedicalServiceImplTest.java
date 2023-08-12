package repository;

import entity.BloodPressure;
import entity.PatientInfo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.alert.SendAlertService;
import service.alert.SendAlertServiceImpl;
import service.medical.MedicalService;
import service.medical.MedicalServiceImpl;


public class MedicalServiceImplTest {

    @Test
    void checkBloodPressureTest() {
        String patientId = "a4938ee6-cc30-45e9-9c72-e16f8b808574";
        String message = "dsdadda";

        SendAlertService alertService = Mockito.mock(SendAlertServiceImpl.class);
//        Mockito.when(alertService.send(message)).thenReturn(System.out.println(message));

        PatientInfoRepository patientInfoRepository = Mockito.mock(PatientInfoFileRepository.class);
        Mockito.when(patientInfoRepository.getById(patientId)).thenReturn(patientInfoRepository.getById(patientId));

        MedicalService medicalService = new MedicalServiceImpl(patientInfoRepository, alertService);

        BloodPressure currentPressure = new BloodPressure(60, 120);
        medicalService.checkBloodPressure(patientId, currentPressure);



    }

}
