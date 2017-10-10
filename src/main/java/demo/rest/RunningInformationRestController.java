package demo.rest;

import demo.domain.RunningInformation;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningInformationRestController {

    private RunningInformationService runningInformationService;

    @Autowired
    public RunningInformationRestController(RunningInformationService runningInformationService){
        this.runningInformationService = runningInformationService;
    }

    @RequestMapping(value = "/running", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<RunningInformation> upload(@RequestBody List<RunningInformation> runningInformation){
        return this.runningInformationService.saveRunningInformation(runningInformation);
    }

    @RequestMapping(value = "/running", method = RequestMethod.GET)
    public Page<RunningInformation> findAllByOrderByHealthWarningLevel(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return this.runningInformationService.findAllByOrderByHealthWarningLevel(new PageRequest(page, size));
    }

    @RequestMapping(value = "/running/{runningId}", method = RequestMethod.GET)
    public Page<RunningInformation> deleteByRunningId(@PathVariable String runningId, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return this.runningInformationService.deleteByRunningId(runningId,new PageRequest(page, size));
    }
}
