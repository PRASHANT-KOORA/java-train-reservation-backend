package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrainService {
    private List<Train> trainList;
    private static final String TrainDbPath = "D:\\IRCTC\\app\\src\\main\\java\\ticket\\booking\\LocalDb\\trains.json";
    ObjectMapper ObjMap=new ObjectMapper();

    public TrainService() throws IOException {
        File trains=new File(TrainDbPath);
        trainList=ObjMap.readValue(trains, new TypeReference<List<Train>>() {});
    }
    public List<Train> searchTrain(String source,String Destination){
        return trainList.stream().filter(train -> validTrain(train,source,Destination)).collect(Collectors.toList());
    }

    private boolean validTrain(Train train, String source, String destination) {
        List<String> allstations=train.getStations();
        int sourceIndex=allstations.indexOf(source);
        int destIndex=allstations.indexOf(destination);
       if(sourceIndex<0||sourceIndex>destIndex){
           return Boolean.FALSE;
       }
       else{
           return Boolean.TRUE;
       }
    }
    private void saveListToFile() throws IOException {
        ObjMap.writeValue(new File(TrainDbPath),trainList);
    }
    public void addTrain(Train train) throws IOException {
        Optional<Train> trainExists=trainList.stream().filter(train1 -> train.getTrainId().equalsIgnoreCase(train1.getTrainId())).findFirst();
        if(trainExists.isPresent()){
            updateTrain(train);
        }
        else{
            trainList.add(train);
            saveListToFile();
        }
    }
    public void updateTrain(Train train) throws IOException {
        OptionalInt ids= IntStream.range(0,trainList.size()).filter(i->trainList.get(i).getTrainId().equalsIgnoreCase(train.getTrainId())).findFirst();
        if(ids.isPresent()){
            trainList.set(ids.getAsInt(), train);
            saveListToFile();
        }
        else{
            addTrain(train);
        }
    }
}
