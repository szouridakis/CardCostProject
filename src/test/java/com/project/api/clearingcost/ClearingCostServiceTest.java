package com.project.api.clearingcost;


import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ClearingCostServiceTest {
    @Mock
    private ClearingCostRepository clearingCostRepository;
    private ClearingCostService underTest;

    @BeforeEach
    void setUp() {
        underTest = new ClearingCostService(clearingCostRepository);
    }


    @Test
    void canGetAllClearingCosts() {
        //when
        underTest.getAllClearingCosts();
        //then
        verify(clearingCostRepository).findAll();
    }

    @Test
    void CanGetClearingCostDetails() {
        //given
        String countryCode="US";
        //when
        underTest.getClearingCostDetails(countryCode);
        //then
        verify(clearingCostRepository).findById(countryCode);
    }

    @Test
    void CanAddClearingCost() {
        //given
        ClearingCost clearingCost = new ClearingCost(
                "CY",
                5
        );
        //when
        underTest.saveOrUpdate(clearingCost);

        //then
        ArgumentCaptor<ClearingCost> clearingCostArgumentCaptor =
                ArgumentCaptor.forClass(ClearingCost.class);

        verify(clearingCostRepository)
                .save(clearingCostArgumentCaptor.capture());

        ClearingCost capturedClearingCost= clearingCostArgumentCaptor.getValue();

        AssertionsForClassTypes.assertThat(capturedClearingCost).isEqualTo(clearingCost);
    }

    @Test
    void CanDeleteClearingCost() {
        //given
        String countryCode="US";
        //when
        underTest.deleteClearingCost(countryCode);
        //then
        verify(clearingCostRepository).deleteById(countryCode);
    }


}
