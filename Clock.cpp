#include <QApplication>
#include <QWidget>
#include <QLabel>
#include <QTimer>
#include <QDateTime>

class DigitalClock : public QWidget {
    Q_OBJECT

public:
    DigitalClock(QWidget *parent = nullptr) : QWidget(parent) {
        timeLabel = new QLabel(this);
        timeLabel->setFont(QFont("Arial", 50));
        timeLabel->setStyleSheet("color: #00FF00; background-color: black;");
        timeLabel->setAlignment(Qt::AlignCenter);

        dayLabel = new QLabel(this);
        dayLabel->setFont(QFont("Ink Free", 25, QFont::Bold));
        dayLabel->setAlignment(Qt::AlignCenter);

        dateLabel = new QLabel(this);
        dateLabel->setFont(QFont("Ink Free", 30));
        dateLabel->setAlignment(Qt::AlignCenter);

        QVBoxLayout *layout = new QVBoxLayout;
        layout->addWidget(timeLabel);
        layout->addWidget(dayLabel);
        layout->addWidget(dateLabel);
        setLayout(layout);

        update();

        QTimer *timer = new QTimer(this);
        connect(timer, &QTimer::timeout, this, &DigitalClock::update);
        timer->start(1000);
    }

private slots:
    void update() {
        QString timeString = QTime::currentTime().toString("h:mm:ss AP");
        timeLabel->setText(timeString);

        QString dayString = QDate::currentDate().toString("dddd");
        dayLabel->setText(dayString);

        QString dateString = QDate::currentDate().toString("MMMM d, yyyy");
        dateLabel->setText(dateString);
    }

private:
    QLabel *timeLabel;
    QLabel *dayLabel;
    QLabel *dateLabel;
};

int main(int argc, char *argv[]) {
    QApplication app(argc, argv);
    DigitalClock clock;
    clock.show();
    return app.exec();
}

#include "main.moc"
