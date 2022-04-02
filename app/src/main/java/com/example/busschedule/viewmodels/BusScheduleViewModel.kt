package com.example.busschedule.viewmodels

import Schedule
import ScheduleDao
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BusScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel(){

    class BusScheduleViewModelFactory(
        private val scheduleDao: ScheduleDao
    ): ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(BusScheduleViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return BusScheduleViewModel(scheduleDao) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    fun fullSchedule(): List<Schedule> = scheduleDao.getAll()

    fun scheduleForStopName(name: String): List<Schedule> = scheduleDao.getByStopName(name)
}