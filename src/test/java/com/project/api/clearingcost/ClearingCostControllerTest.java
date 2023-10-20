package com.project.api.clearingcost;

import com.project.api.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ClearingCostControllerTest {

    private ClearingCostController underTest;
    @Mock
    private ClearingCostService clearingCostService;

    @BeforeEach
    void setUp() {
        underTest = new ClearingCostController(clearingCostService);
    }

    @Test
    void GetWillThrowExceptionWhenCountryDoesNotExist() {
        //given
        String countryCode = "CY";

        given(clearingCostService.getClearingCostDetails(countryCode))
                .willReturn(Optional.empty());
        //when
        //then
        assertThatThrownBy(() -> underTest.getClearingCostById(countryCode))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Country: '" + countryCode + "' not found!");
    }


    @Test
    void UpdateWillThrowExceptionWhenCountryDoesNotExist() {

        //given
        String countryCode = "CY";
        ClearingCost clearingCost = new ClearingCost(countryCode,6);

        given(clearingCostService.getClearingCostDetails(countryCode))
                .willReturn(Optional.empty());
        //when
        //then
        assertThatThrownBy(() -> underTest.updateClearingCost(countryCode,clearingCost))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Country: '" + countryCode + "' not found!");
    }

    @Test
    void DeleteWillThrowExceptionWhenCountryDoesNotExist() {
        //given
        String countryCode = "CY";

        given(clearingCostService.getClearingCostDetails(countryCode))
                .willReturn(Optional.empty());
        //when
        //then
        assertThatThrownBy(() -> underTest.deleteClearingCost(countryCode))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Country: '" + countryCode + "' not found!");
    }
}