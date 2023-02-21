package com.MI8.MI8.components;

import com.MI8.MI8.models.Item;
import com.MI8.MI8.models.Player;
import com.MI8.MI8.models.Room;
import com.MI8.MI8.repositories.GameRepository;
import com.MI8.MI8.repositories.ItemRepository;
import com.MI8.MI8.repositories.PlayerRepository;
import com.MI8.MI8.repositories.RoomRepository;
import com.MI8.MI8.services.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    GameRepository gameRepo;
    @Autowired
    PlayerRepository playerRepo;
    @Autowired
    RoomRepository roomRepo;
    @Autowired
    ItemRepository itemRepo;

    @Autowired
    RoomServices roomServices;


    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //room id 1
        Room plaza = new Room("You are droped of at the Plaza outside the building" +
                "/nIn front of you is the front door");
        roomRepo.save(plaza);
        //room id 2
        Room basement = new Room("You enter the basement, it's very dark in here");
        roomRepo.save(basement);
        //room id 3
        Room lobby = new Room("You enter the lobby there is a reception desk with a bored looking receptionist." +
                "/nBy the elevators you see some guards.");
        roomRepo.save(lobby);
        //room id 4
        Room elevator = new Room("You've made it to the elevator agent " +name+ ". It seems the new owners have denied access to the basement floor. Should you choose you can access it via an old and discreet hatch panel above you. Our previous operatives have "+
                "ensured this hatch will be loose enough for your access. Alternatively you can access the Security station or head straight for the CEO's Office. choose wisely agent.");
        roomRepo.save(elevator);
        //room id 5
        Room airvents = new Room("You slither along the dark and narrow access vents ,avoiding any unwanted attention.");
        roomRepo.save(airvents);
        //room id 6
        Room security = new Room("Your disguise has enabled you to get this far however be aware agent, you must act swiftly. The security personnel will be on the lookout. We have instigated a scandal on the lower floors to detract their attention." +
                "retrieve one of the spare keycards and make it quick.");
        roomRepo.save(security);
        //room id 7
        Room vault = new Room("Well done agent, the tracker you have placed on their criminal earnings will allow use to intercept their operation when they least expect it, catching them red handed. we have set up an extraction point. Great work agent.");
        roomRepo.save(vault);
        //room id 8
        Room ceosOffice = new Room("Quickly agent, access the computer and retrieve the laptop. We need the documents within as evidence of Specter's unscrupulous and opportunistic dealings. we have set up an extraction point. Great work agent.");
        roomRepo.save(ceosOffice);
        //room id 9
        Room extractionPoint = new Room("You have successfully managed to cripple Specters growing criminal influence across the globe, whilst they remain at large, your accomplishments will get us one step closer to stopping their nefarious affairs. youll be" +
                "returning to MI8 HQ for your next briefing agent.");

        //adding path to the plaza
        roomServices.addRoom(plaza,2);
        roomServices.addRoom(plaza,3);
        roomRepo.save(plaza);

        //adding path to the basement
        roomServices.addRoom(basement,5);
        roomRepo.save(basement);

        //adding path to the Lobby
        roomServices.addRoom(lobby,4);
        roomRepo.save(lobby);

        //adding path to the Elevator
        roomServices.addRoom(elevator,2);
        roomServices.addRoom(elevator,6);
        roomServices.addRoom(elevator,8);
        roomRepo.save(elevator);

        //adding path to the airvents
        roomServices.addRoom(airvents,7);
        roomRepo.save(airvents);

        //adding path to the vaults
        roomServices.addRoom(extractionPoint,9);
        roomRepo.save(vault);

        //adding path to the security
        roomServices.addRoom(security,4);
        roomRepo.save(security);

        //adding path to the ceosOffice
        roomServices.addRoom(extractionPoint,9);
        roomServices.addRoom(security,4);
        roomRepo.save(ceosOffice);



        //items
        Item torch = new Item("This is a torch, you can use it to light up the room","Common");
        itemRepo.save(torch);

        Item multiTool = new Item("This is a torch, you can use it to remove screws","Common");
        itemRepo.save(multiTool);

        Item keycard = new Item("This keycard allows you to gain access to the CeosOffice.","rare");
        itemRepo.save(keycard);

        Item laptop = new Item ("Contains evidence of Specters villainous international operations.", "superRare");
        itemRepo.save(laptop);



    }
}
