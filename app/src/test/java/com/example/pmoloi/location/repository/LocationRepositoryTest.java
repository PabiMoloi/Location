package com.example.pmoloi.location.repository;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.pmoloi.location.data.dao.LocationDao;
import com.example.pmoloi.location.data.model.LocationModel;
import com.example.pmoloi.location.data.repository.ILocationRepository;
import com.example.pmoloi.location.util.TestLocationGenerator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import repository.MockLocationRepositoryImpl;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LocationRepositoryTest {

    @Mock
    private LocationDao locationDao;

    private ILocationRepository iLocationRepository;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        iLocationRepository = new MockLocationRepositoryImpl(locationDao);
    }

    @Test
    public void getLocations_GetLocationsFunctionTest() throws InterruptedException {
        iLocationRepository.getAllLocations();
        verify(locationDao).getAllLocations();
    }

    @Test
    public void insertLocation_InsertLocationFunctionTest() {
        LocationModel locationModel = TestLocationGenerator.getGeneratedLocation();
        iLocationRepository.insertLocation(locationModel);
        verify(locationDao).insertLocation(locationModel);
    }

}
