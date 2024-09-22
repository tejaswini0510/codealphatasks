import cv2
import numpy as np
from ultralytics import YOLO  # type: ignore

def main():
    # Load the YOLO model
    model = YOLO("yolov8l.pt")  # Use the appropriate YOLO model

    cap = cv2.VideoCapture(0)  # Capture video from the webcam

    while True:
        ret, frame = cap.read()
        if not ret:
            break

        # Perform object detection
        results = model(frame, agnostic_nms=True)[0]

        # Extract detections
        boxes = results.boxes.xyxy.cpu().numpy()  # x1, y1, x2, y2
        confidences = results.boxes.conf.cpu().numpy()
        class_ids = results.boxes.cls.cpu().numpy()

        # Draw bounding boxes and labels
        for box, confidence, class_id in zip(boxes, confidences, class_ids):
            x1, y1, x2, y2 = map(int, box)
            label = f"{model.names[int(class_id)]} {confidence:.2f}"
            cv2.rectangle(frame, (x1, y1), (x2, y2), (255, 0, 0), 2)
            cv2.putText(frame, label, (x1, y1 - 10), cv2.FONT_HERSHEY_SIMPLEX, 0.5, (255, 255, 255), 2)

        # Display the resulting frame
        cv2.imshow("Object Detection", frame)

        # Exit on 'q' key
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

    cap.release()
    cv2.destroyAllWindows()

if __name__ == "__main__":
    main()
