import androidx.room.RoomDatabase

abstract class AppDatabase: RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao
    companion object {
        
    }
}