package Dao;

import model.Vendor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {

    private final String FILE_NAME = "vendors.txt";

    // CREATE
    public void addVendor(Vendor vendor) {

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(FILE_NAME, true))) {

            bw.write(vendor.toString());
            bw.newLine();

            System.out.println("Vendor Added Successfully!");

        } catch (IOException e) {
            System.out.println("Error Adding Vendor");
        }
    }

    // READ
    public List<Vendor> getAllVendors() {

        List<Vendor> vendors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Vendor vendor = new Vendor(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        Double.parseDouble(data[5]),
                        Boolean.parseBoolean(data[6])
                );

                vendors.add(vendor);
            }

        } catch (IOException e) {
            System.out.println("Error Reading Vendors");
        }

        return vendors;
    }

    // SEARCH BY CATEGORY
    public void searchByCategory(String category) {

        for (Vendor vendor : getAllVendors()) {

            if (vendor.getCategory().equalsIgnoreCase(category)) {
                System.out.println(vendor);
            }
        }
    }

    // SEARCH BY LOCATION
    public void searchByLocation(String location) {

        for (Vendor vendor : getAllVendors()) {

            if (vendor.getLocation().equalsIgnoreCase(location)) {
                System.out.println(vendor);
            }
        }
    }

    // SEARCH BY PRICE
    public void searchByPrice(double maxPrice) {

        for (Vendor vendor : getAllVendors()) {

            if (vendor.getPrice() <= maxPrice) {
                System.out.println(vendor);
            }
        }
    }

    // UPDATE
    public void updateVendor(int vendorId, double newPrice) {

        List<Vendor> vendors = getAllVendors();

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(FILE_NAME))) {

            for (Vendor vendor : vendors) {

                if (vendor.getId() == vendorId) {
                    vendor.setPrice(newPrice);
                }

                bw.write(vendor.toString());
                bw.newLine();
            }

            System.out.println("Vendor Updated Successfully!");

        } catch (IOException e) {
            System.out.println("Error Updating Vendor");
        }
    }

    // DELETE
    public void deleteVendor(int vendorId) {

        List<Vendor> vendors = getAllVendors();

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(FILE_NAME))) {

            for (Vendor vendor : vendors) {

                if (vendor.getId() != vendorId) {

                    bw.write(vendor.toString());
                    bw.newLine();
                }
            }

            System.out.println("Vendor Deleted Successfully!");

        } catch (IOException e) {
            System.out.println("Error Deleting Vendor");
        }
    }
}