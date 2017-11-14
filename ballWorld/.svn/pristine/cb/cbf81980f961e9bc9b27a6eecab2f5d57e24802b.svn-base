package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * @author ZihanLi, Yiran Wei
 *
 */
public class MainFrame<TDropListItem, TDropListItem1> extends JFrame {
	private static final long serialVersionUID = -9089334382685717126L;
	private JPanel contentPane;
	private IView2ModelCtrlAdapter<TDropListItem, TDropListItem1> _modelCtrlAdapter;
	private IView2ModelPaintAdapter _modelPaintAdapter = IView2ModelPaintAdapter.NULL_OBJECT; // Insures that the adapter is always valid
	private final JPanel centerpnl = new JPanel() {
		private static final long serialVersionUID = -872444218515942499L;

		/**
		 * Overridden paintComponent method to paint a shape in the panel.
		 * @param g The Graphics object to paint on.
		 **/
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // Do everything normally done first, e.g. clear the screen.
			_modelPaintAdapter.paint(g);
		}
	};

	private final JPanel northpnl = new JPanel();
	private final JButton btnClearBalls = new JButton("Clear balls");
	private final JPanel choosePnl = new JPanel();
	private final JButton btnCreateBall = new JButton("Create a seleted ball");
	private final JComboBox<TDropListItem> strategy_1 = new JComboBox<TDropListItem>();
	private final JComboBox<TDropListItem> strategy_2 = new JComboBox<TDropListItem>();
	private final JButton btnCombine = new JButton("Combine!");
	private final JButton btnAddList = new JButton("Add to List");
	private final JPanel switchPnl = new JPanel();
	private final JButton btnMakeSwitcher = new JButton("Make Switcher");
	private final JButton btnSwitch = new JButton("Switch!");
	private final JTextField strategyText = new JTextField();
	private final JPanel addPnl = new JPanel();
	private final JPanel paintStraPnl = new JPanel();
	private final JButton btnAdd = new JButton("add");
	private final JLabel lblStrategy = new JLabel("Paint Strategy");
	private final JTextField PaintStrategyText = new JTextField();
	private final JComboBox<TDropListItem1> paintStrategy = new JComboBox<TDropListItem1>();

	/**
	 * Create the frame.
	 */
	public MainFrame(IView2ModelCtrlAdapter<TDropListItem, TDropListItem1> modelCtrlAdapter,
			IView2ModelPaintAdapter modelPaintAdapter) {
		PaintStrategyText.setText("Ball");
		PaintStrategyText.setToolTipText("name of paint strategy");
		PaintStrategyText.setColumns(10);
		_modelCtrlAdapter = modelCtrlAdapter;
		_modelPaintAdapter = modelPaintAdapter;

		initGUI();
	}

	private void initGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		centerpnl.setToolTipText("center panel");
		centerpnl.setBackground(Color.WHITE);

		contentPane.add(centerpnl, BorderLayout.CENTER);
		northpnl.setToolTipText("north panel");
		northpnl.setBackground(Color.YELLOW);

		contentPane.add(northpnl, BorderLayout.NORTH);
		btnClearBalls.setToolTipText("click here to clear all the balls");
		btnClearBalls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_modelCtrlAdapter.clearBalls();
			}
		});
		addPnl.setLayout(new GridLayout(0, 1, 0, 0));

		northpnl.add(addPnl);
		strategyText.setToolTipText("name of strategy, both full and abbreviated name is supported");
		addPnl.add(strategyText);
		strategyText.setText("Straight");
		strategyText.setColumns(10);
		btnAddList.setToolTipText("add strategy to both dropLists");
		addPnl.add(btnAddList);
		btnAddList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TDropListItem o = (TDropListItem) _modelCtrlAdapter.addStrategy(strategyText.getText());
				if (null == o)
					return; // just in case

				strategy_1.insertItemAt(o, 0);
				strategy_2.insertItemAt(o, 0);
			}
		});

		northpnl.add(choosePnl);
		btnCreateBall.setToolTipText("instantiate a ball with strategy in the upper droplist");
		btnCreateBall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_modelCtrlAdapter.makeBall(centerpnl, strategy_1.getItemAt(strategy_1.getSelectedIndex()),
						paintStrategy.getItemAt(paintStrategy.getSelectedIndex()));
			}
		});
		choosePnl.setLayout(new GridLayout(0, 1, 0, 0));
		choosePnl.add(btnCreateBall);
		strategy_1.setToolTipText("choose the update strategy");
		choosePnl.add(strategy_1);
		strategy_2.setToolTipText("choode the update strategy to combine with the upper one");
		choosePnl.add(strategy_2);
		btnCombine.setToolTipText(
				"combine both strategies form both droplists to a single strategy that will be added to both droplists");
		btnCombine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TDropListItem o = _modelCtrlAdapter.combineStrategies(
						strategy_1.getItemAt(strategy_1.getSelectedIndex()),
						strategy_2.getItemAt(strategy_2.getSelectedIndex()));
				strategy_1.insertItemAt(o, 0);
				strategy_2.insertItemAt(o, 0);
			}
		});
		choosePnl.add(btnCombine);

		northpnl.add(switchPnl);
		btnMakeSwitcher.setToolTipText("instantiate a ball that can switch strategies");
		btnMakeSwitcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_modelCtrlAdapter.makeSwitchBall(centerpnl, paintStrategy.getItemAt(paintStrategy.getSelectedIndex()));
			}
		});
		switchPnl.setLayout(new GridLayout(0, 1, 0, 0));

		switchPnl.add(btnMakeSwitcher);
		btnSwitch.setToolTipText(
				"swith the strategy of all the switchers in the panel to the strategy that is seleted in the upper droplist");
		btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_modelCtrlAdapter.switchStrategy(strategy_1.getItemAt(strategy_1.getSelectedIndex()));
			}
		});

		switchPnl.add(btnSwitch);

		northpnl.add(btnClearBalls);

		northpnl.add(paintStraPnl);
		paintStraPnl.setLayout(new GridLayout(0, 1, 0, 0));

		paintStraPnl.add(lblStrategy);

		paintStraPnl.add(PaintStrategyText);
		btnAdd.setToolTipText("add strategy to below List");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TDropListItem1 o = (TDropListItem1) _modelCtrlAdapter.addPaintStrategy(PaintStrategyText.getText());
				if (null == o)
					return; // just in case

				paintStrategy.insertItemAt(o, 0);
			}
		});
		paintStraPnl.add(btnAdd);
		paintStrategy.setToolTipText("choose the paint strategy");

		paintStraPnl.add(paintStrategy);
	}

	/**
	 * call the repaint method to regenerate the picture
	 */
	public void update() {
		centerpnl.repaint();
	}

	/**
	 * to set the frame visible.
	 */
	public void start() {
		setVisible(true);
	}

}
