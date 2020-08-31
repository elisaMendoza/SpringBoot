package com.elisa.relationships.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.elisa.relationships.models.License;
import com.elisa.relationships.repos.LicenseRepo;

@Service
public class LicenseService {
	private final LicenseRepo licenseRepo;
	
	public LicenseService(LicenseRepo licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	
	public License createLicense(License l) {
		return licenseRepo.save(l);
	}
	public License findLicense(Long id) {
        Optional<License> option = licenseRepo.findById(id);
        if(option.isPresent()) {
            return option.get();
        } else {
            return null;
        }
	}
		public void deleteLicense(Long id) {
	       licenseRepo.deleteById(id);
	       }
		
		public License updateLicense(Long id, Date expirationDate, String state) {
			Optional<License> temp = licenseRepo.findById(id);
			 if(temp.isPresent()) {
				 License l = temp.get();
				 l.setExpirationDate(expirationDate);
				 l.setState(state);
				 return licenseRepo.save(l);
		        } else {
		        	return null;
		        }
		}	
	    public License updateLicense(License l) {
	    	return licenseRepo.save(l);
	    }
		//Constructor numero de licencia
		public static int licenseNumber;
		public static int getLicenseNumber() {
			return licenseNumber;
		}
		//setter Numero de Licencia
		public static void setLicenseNumber(int licenseNumber) {
			LicenseService.licenseNumber = licenseNumber;
		}
		//metodo para convertir numero de licencia en String
		public String generateLicenseNumber() {
			if(licenseRepo.findTopByOrderByNumberDesc().isEmpty()) {
				licenseNumber +=1;
				return stringLicenseNumber(licenseNumber);
			}
			else {
				List<License> top = licenseRepo.findTopByOrderByNumberDesc() ;
				licenseNumber = 1+(Integer.parseInt(top.get(0).getNumber()));
				return stringLicenseNumber(licenseNumber);
			}
		}
		public String stringLicenseNumber(int num) {
			String format = String.format("%06d", num);
			return format;
		}
}
