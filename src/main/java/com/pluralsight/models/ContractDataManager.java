package com.pluralsight.models;

import com.pluralsight.contracts.Contract;

import java.util.ArrayList;
import java.util.List;

public class ContractDataManager {
    /*
     * *** Props ***
     */
    // List property
    private List<Contract> contractList;
    /*
     * *** Const ***
     */
    public ContractDataManager() {
        this.contractList  = new ArrayList<>();
    }
    /*
     * *** Getters/Setters ***
     */
    public List<Contract> getContractList() {
        return contractList;
    }
    /*
     * *** Methods ***
     */
    // Return a list of contracts filtered by contract type.
//    public List<Contract> getContractsByType(String type) {
//        // List to be filled with only the filtered contracts and then returned.
//        List<Contract> filteredcontractList = new ArrayList<>();
//        // Loop through all contracts and add the relevant ones to the return list.
//        for(Contract contract : contractList) {
//            if(contract.getcontractType().toUpperCase().contains(type.toUpperCase())) {
//                filteredcontractList.add(contract);
//            }
//        }
//        // Return the filtered list of contracts.
//        return filteredcontractList;
//    }

    // Return a list of contracts matching the passed vin.
    public Contract searchForContract(String vin, String name, String date) {
        Contract returnContract = null;
        // Loop through all contracts and add the relevant ones to the return list.
        for(Contract contract : contractList) {
            if(contract.getCustomerName().equalsIgnoreCase(name) && contract.getDate().equals(date)) {
                Vehicle vehicle = contract.getVehicle();
                if(vehicle != null && vehicle.getVin().equals(vin)) {
                    returnContract = contract;
                    break;
                }
            }
        }
        // Return the filtered list of contracts.
        return returnContract;
    }

    // Return a list of all contracts.
    public List<Contract> getAllContracts() {
        return contractList;
    }

    // Add a contract to the list.
    public void addContract(Contract contract) {
        this.contractList.add(contract);
    }

    // Remove a contract from the list of contracts.
    public void removeContract(Contract contract) {
        this.contractList.remove(contract);
    }
}
