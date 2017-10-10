package demo.service.impl;

import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunningInformationServiceImpl implements RunningInformationService{

    private RunningInformationRepository runningInformationRepository;

    @Autowired
    public RunningInformationServiceImpl(RunningInformationRepository runningInformationRepository){
        this.runningInformationRepository = runningInformationRepository;
    }

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformation) {
        return runningInformationRepository.save(runningInformation);
    }

    @Override
    public Page<RunningInformation> findAllByOrderByHealthWarningLevel(Pageable pageable) {
        return runningInformationRepository.findAllByOrderByHealthWarningLevel(pageable);
    }

    @Override
    public Page<RunningInformation> deleteByRunningId(String runningId, Pageable pageable) {
        return runningInformationRepository.deleteByRunningId(runningId, pageable);
    }
}
